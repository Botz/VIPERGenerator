#Description
This is a code generator for [Clean Architecture](https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html), [VIPER](https://www.objc.io/issues/13-architecture/viper/)

#USAGE

./VIPERGenerator

- Enter Template(Swift, Java)
- Enter modulename
- For Java enter packagename

#Templates

You can use own templates, just provide your code templates in a subdirectory of templates.

Placeholders:
- `##MODULENAME##` will be replaced
- `##PACKAGENAME##` for java code, the package name of your module
- `##USERNAME##` will be replaced with your terminal username
- `##DATE##` will be replaced by current date with format: dd.MM.YYYY
