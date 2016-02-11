package main

import (
  "io/ioutil"
  "log"
  "strings"
  "bytes"
  "os/user"
  "time"
  "fmt"
  "os"
  "bufio"
  "github.com/kardianos/osext"
)

var moduleName string
var moduleNamePackage string
var packageName string
var templateDirectory string
var outputDir string

func main() {
  getConsoleInput()
  executableDirectory, _ := osext.ExecutableFolder()
  var directory = executableDirectory + "/templates/" + templateDirectory + "/"
  var fileInfos, err = ioutil.ReadDir(directory)
  if err != nil {
    log.Fatal(err)
  }

  if (templateDirectory != "swift") {
    outputDir = outputDir + "/" + moduleNamePackage
  } else {
    outputDir = outputDir + "/" + moduleName
  }

  os.Mkdir(outputDir, 0777)

  for _,fileInfo := range fileInfos {
    printFile(directory, fileInfo.Name())
  }
}

func printFile(directory string, fileName string) {
  var data, err = ioutil.ReadFile(directory + "/" + fileName)

  if (err != nil) {
    log.Fatal(err)
  }

  r := strings.NewReplacer("##MODULENAME##", moduleName, "##MODULENAME_PACKAGE##", moduleNamePackage, "##MODULENAME_UPPERCASE##", strings.ToUpper(moduleName), "##PACKAGENAME##", packageName, "##USERNAME##", getUsername(), "##DATE##", getDate())
  newString := r.Replace(string(data))

  ioutil.WriteFile(outputDir + "/" + moduleName + fileName, []byte(newString), 0777)
}

func getUsername() string {
  var currentUser, err = user.Current()

  if err != nil {
    return "Unnamed"
  }

  return currentUser.Name
}

func getDate() string {
  var t = time.Now()
  return fmt.Sprintf("%v.%d.%v", t.Day(), t.Month(), t.Year())
}

func getConsoleInput() {
  reader := bufio.NewReader(os.Stdin)

  for true {
    fmt.Print("Enter template (JAVA, JAVAV2, SWIFT): ")
    templateDirectory, _ = reader.ReadString('\n')
    templateDirectory = strings.ToLower(strings.TrimRight(templateDirectory, "\n"))

    if (templateDirectory != "java" && templateDirectory != "javav2" && templateDirectory != "swift") {
      continue
    } else {
      break
    }
  }

  fmt.Print("Enter module name (e.g. BasketList): ")
  moduleName, _ = reader.ReadString('\n')
  moduleName = strings.TrimRight(moduleName, "\n")
  moduleNamePackage = makeFirstLowerCase(moduleName)

  if (templateDirectory != "swift") {
    fmt.Print("Enter Java PackageName (e.g. com.company.mylittleProject): ")
    packageName, _ = reader.ReadString('\n')
    packageName = strings.TrimRight(packageName, "\n")
  }

  fmt.Print("Enter absolute output path: ")
  outputDir, _ = reader.ReadString('\n')
  outputDir = strings.TrimRight(outputDir, "\n")
}

func makeFirstLowerCase(s string) string {

    if len(s) < 2 {
        return strings.ToLower(s)
    }

    bts := []byte(s)

    lc := bytes.ToLower([]byte{bts[0]})
    rest := bts[1:]

    return string(bytes.Join([][]byte{lc, rest}, nil))
}
