package main

//import "fmt"
import (
  "io/ioutil"
  "log"
  "strings"
  "os/user"
  "time"
  "fmt"
  "os"
  "bufio"
  "github.com/kardianos/osext"
)

var moduleName string
var packageName string
var templateDirectory string
var outputDir string

func main() {
  getConsoleInput()
  log.Println(" TTT" + templateDirectory + "TTT ")
  log.Println(moduleName)

  executableDirectory, _ := osext.ExecutableFolder()
  outputDir = executableDirectory + "/output"
  var directory = executableDirectory + "/templates/" + templateDirectory + "/"
  var fileInfos, err = ioutil.ReadDir(directory)
  if err != nil {
    log.Fatal(err)
  }


  os.RemoveAll(outputDir)
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

  r := strings.NewReplacer("##MODULENAME##", moduleName, "##PACKAGENAME##", packageName, "##USERNAME##", getUsername(), "##DATE##", getDate())
  newString := r.Replace(string(data))

  ioutil.WriteFile(outputDir + "/" + moduleName + fileName, []byte(newString), 0777)
}

func getUsername() string {
  var currentUser, err = user.Current();

  if err != nil {
    return "Unnamed"
  }

  return currentUser.Name
}

func getDate() string {
  var t = time.Now();
  return fmt.Sprintf("%v.%d.%v", t.Day(), t.Month(), t.Year())
}

func getConsoleInput() {
  reader := bufio.NewReader(os.Stdin)
  fmt.Print("Enter template: (JAVA, SWIFT):")
  templateDirectory, _ = reader.ReadString('\n')
  templateDirectory = strings.ToLower(strings.TrimRight(templateDirectory, "\n"))
  fmt.Print("Enter module name(e.g. BasketList): ")
  moduleName, _ = reader.ReadString('\n')
  moduleName = strings.TrimRight(moduleName, "\n")
  if (templateDirectory != "swift") {
    fmt.Print("Enter Java PackageName(e.g. com.company.mylittleProject):")
    packageName, _ = reader.ReadString('\n')
    packageName = strings.TrimRight(packageName, "\n")
  }
}
