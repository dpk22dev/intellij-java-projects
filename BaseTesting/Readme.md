while building project following issues were prevalent

### class file has wrong version 55.0, should be 52.0
dependency mockito was build with java v20 
but my project was using java v8

changed settings in intellij to use v20 globally as well as in project structure.
Not exactly sure how many places i have updated, it might not break other projects

### second build was very slow, i did below:
increased build heap to 2G
disabled extra extensions in plugins
