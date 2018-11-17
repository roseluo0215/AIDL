# AIDL应用进程之间传递数据

1.新建两个app工程，分别叫client和service，client用来调用数据，service用来提供服务。

2.在service工程中创建两个aidl，分别为IstudentAidl.aidl和StudentInfo.aidl文件，路径为main/aidl/com/lc/service包下面

3.创建一个StudentInfo实体类用来存放学生信息，创建一个StudentService继承Service 做相应的逻辑并在在manifest中注册。

4.把service工程中的aidl文件夹复制到client工程中的main路径下

5.复制StudentInfo实体类文件到client工程中，并且和在service工程中的文件路径一致

6在client工程MainActivity中进行逻辑处理