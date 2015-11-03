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
)

var moduleName = "PlacePicker"
var packageName = "de.jochen-schweizer.jsnow.modules.placePicker"
var templateDirectory string

func main() {
  getConsoleInput()
  log.Println(" TTT" + templateDirectory + "TTT ")
  log.Println(moduleName)
  var directory = "./templates/" + templateDirectory + "/"
  var fileInfos, err = ioutil.ReadDir(directory)
  if err != nil {
    log.Fatal(err)
  }

  for _,fileInfo := range fileInfos {
    printFile(directory, fileInfo.Name())
  }
}

func printFile(directory string, fileName string) {
  var outputDir = "/tmp"
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
  fmt.Print("Enter template: (JAVA):")
  templateDirectory, _ = reader.ReadString('\n')
  templateDirectory = strings.TrimRight(templateDirectory, "\n")
  fmt.Print("Enter module name(e.g. BasketList): ")
  moduleName, _ = reader.ReadString('\n')
  moduleName = strings.TrimRight(moduleName, "\n")
}
