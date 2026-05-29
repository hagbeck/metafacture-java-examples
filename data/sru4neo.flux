
default namespacesFile = "sru4neo.namespaces.properties";

default sourceFile = "data/inputPython.json";
default targetFile = "data/sru4neo.output.xml";

default fixFile = "sru4neo.fix";

sourceFile|
open-file|
as-records|
decode-json|
fix(fixFile)|
encode-xml(writeroottag="false", recordtag="", namespaceFile=namespacesFile, attributemarker="@", valuetag="value")|
write(targetFile);
