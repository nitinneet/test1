import static eu.inuits.PythonCompiler.*

def call(String directory = '.') {
echo("Compiling ${directory}")
compileDirectory(this, directory)
}
