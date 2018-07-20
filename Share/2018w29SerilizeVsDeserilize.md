#### Java serialization and deserialization

* Serializaiton : converts the state of an *object* (not class) to a byte stream
* Deserialization : load a static stream to the actual java object in memory

*Why serialization is needed?*
The static stream (sequence) of byte can be
* saved to database (persist state of an object) 
* transferred over network.

Ojects can be serializable by implement interface `java.io.Serializable`.
The `ObjectOutputStream` class contains *writeObject()* method for serializing an object to a stream of bytes. ObjectOutputStream can write *primitive types* and graphs of objects to an OutputStream as a stream of bytes.
```
public final void writeObject(Object o) throws IOException;
```

The `ObjectInputStream` class contains *readObject()* method for reading a stream of bytes and cast back to the orginl object.

```
public final Object readObject() throws IOException, ClassNotFoundException
```

>Note: 
* Static fields belong to a class are not serialized.
* Keyword "transient" to ignore non-static class field during serialization
* if parent class has implement serializable interface then child class doesn't need to impement serializable interface, vice-versa is not true.

#### Serialization Caveats

Serial version UID:
The JVM associates a version number with each serializable class. this version number is called *serial version UID*, 
which is used to verify the saved and loaded objects have some atrributes and thus are compatible on serialization.

If a serializable class doesn't decalre a serial version UID, the jvm will generate one automatically at run-time.


#### Reference:
1. http://www.baeldung.com/java-serialization
2. https://www.geeksforgeeks.org/serialization-in-java/

