# Java Core Concepts and Serialization Demo

This project demonstrates core Java concepts, including runtime information, date/time handling, and object serialization.

The project is structured as a Maven-based Java application that showcases various aspects of Java programming. It includes examples of working with the `Runtime` class, manipulating date and time using the `java.time` package, and implementing serialization for custom objects.

Key features of this project include:
- Retrieval and logging of runtime environment information
- Demonstration of time zone handling and business hour calculations
- Implementation of custom serialization for a `StudentModel` class
- Unit tests to verify the functionality of each component

## Repository Structure

```
.
├── pom.xml
├── README.md
└── src
    └── main
        ├── java
        │   └── com
        │       ├── java
        │       │   ├── lang
        │       │   │   └── RuntimeTest.java
        │       │   └── util
        │       │       └── DateTest.java
        │       └── serialization
        │           ├── SerializationTest.java
        │           └── StudentModel.java
        └── resources
            └── log4j.xml
```

Key Files:
- `pom.xml`: Maven project configuration file
- `src/main/java/com/java/lang/RuntimeTest.java`: Tests for Runtime class functionality
- `src/main/java/com/java/util/DateTest.java`: Demonstrates date and time operations
- `src/main/java/com/serialization/SerializationTest.java`: Tests serialization and deserialization
- `src/main/java/com/serialization/StudentModel.java`: Serializable model class

## Usage Instructions

### Installation

Prerequisites:
- Java Development Kit (JDK) 17 or later
- Apache Maven 3.6.0 or later

To install the project, follow these steps:

1. Clone the repository:
   ```
   git clone <repository-url>
   cd core-java
   ```

2. Build the project using Maven:
   ```
   mvn clean install
   ```

### Running Tests

To run the tests, execute the following command:

```
mvn test
```

### Code Examples

1. Retrieving Runtime Information:

```java
Runtime runtime = Runtime.getRuntime();
Runtime.Version version = Runtime.version();
System.out.println("Java Version: " + version);
System.out.println("Available Processors: " + runtime.availableProcessors());
```

2. Working with ZonedDateTime:

```java
ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("-05:00"));
int hour = zonedDateTime.getHour();
boolean isBusinessHour = hour >= 9 && hour <= 17;
System.out.println("Current hour: " + hour + ", Is business hour: " + isBusinessHour);
```

3. Serializing and Deserializing Objects:

```java
StudentModel student = new StudentModel();
student.setId(1);
student.setName("John Doe");

// Serialization
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
    oos.writeObject(student);
}

// Deserialization
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
    StudentModel deserializedStudent = (StudentModel) ois.readObject();
    System.out.println("Deserialized student: " + deserializedStudent);
}
```

### Troubleshooting

1. ClassNotFoundException during deserialization:
   - Ensure that the `StudentModel` class is in the classpath when deserializing.
   - Check if the `serialVersionUID` in the `StudentModel` class matches the serialized object.

2. Incorrect time zone calculations:
   - Verify that the correct `ZoneId` is being used in `ZonedDateTime.now(ZoneId.of("-05:00"))`.
   - Ensure system time and time zone settings are correct.

3. Serialization IOException:
   - Check file permissions and available disk space.
   - Verify that all non-transient fields in `StudentModel` are serializable.

For debugging:
- Enable verbose logging by modifying `log4j.xml` to set the root logger to DEBUG level.
- Use a debugger to step through the `SerializationTest` class to inspect object states during serialization and deserialization.

## Data Flow

The data flow in this project primarily revolves around the serialization and deserialization process:

1. A `StudentModel` object is created with an ID and name.
2. The object is serialized to a file using `ObjectOutputStream`.
3. The serialized data is then read from the file using `ObjectInputStream`.
4. The deserialized object is compared with the original to verify the process.

```
[StudentModel] -> [Serialization] -> [File] -> [Deserialization] -> [StudentModel]
```

Note: The `StudentModel` class implements custom `defaultWriteObject` and `defaultReadObject` methods, which are called during the serialization and deserialization process, respectively.