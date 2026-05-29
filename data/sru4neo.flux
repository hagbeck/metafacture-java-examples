
default namespacesFile = "sru4neo.namespaces.properties";

default sourceFile = "source.json";
default targetFile = "result.xml";

default fixFile = "sru4neo.fix";

sourceFile|
open-file|
as-records|
decode-json|
fix(fixFile)|
encode-xml(writeroottag="false", recordtag="", namespaceFile=namespacesFile, attributemarker="@", valuetag="value")|
write(targetFile);
