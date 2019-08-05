Demonstrates a regression in jackson-databind 2.9.9.2. Running the test finishes with an exception:
```
java.lang.NullPointerException
	at com.fasterxml.jackson.databind.type.ResolvedRecursiveType.getBindings(ResolvedRecursiveType.java:42)
	at com.fasterxml.jackson.databind.type.TypeFactory._fromAny(TypeFactory.java:1243)
	at com.fasterxml.jackson.databind.type.TypeFactory._fromParamType(TypeFactory.java:1452)
	at com.fasterxml.jackson.databind.type.TypeFactory._fromAny(TypeFactory.java:1221)
	at com.fasterxml.jackson.databind.type.TypeFactory._resolveSuperInterfaces(TypeFactory.java:1367)
	at com.fasterxml.jackson.databind.type.TypeFactory._fromClass(TypeFactory.java:1314)
	at com.fasterxml.jackson.databind.type.TypeFactory._fromAny(TypeFactory.java:1217)
	at com.fasterxml.jackson.databind.type.TypeFactory.constructType(TypeFactory.java:631)
	at com.fasterxml.jackson.databind.cfg.MapperConfig.constructType(MapperConfig.java:281)
	at com.fasterxml.jackson.databind.cfg.MapperConfig.introspectClassAnnotations(MapperConfig.java:311)
	at com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.findTypeDeserializer(BasicDeserializerFactory.java:1571)
	at com.fasterxml.jackson.databind.DeserializationContext.findRootValueDeserializer(DeserializationContext.java:483)
	at com.fasterxml.jackson.databind.ObjectMapper._findRootDeserializer(ObjectMapper.java:4191)
	at com.fasterxml.jackson.databind.ObjectMapper._readValue(ObjectMapper.java:3980)
	at com.fasterxml.jackson.databind.ObjectMapper.readTree(ObjectMapper.java:2385)
	at com.example.JacksonTest.parseJson(JacksonTest.java:33)
	at com.example.JacksonTest.testNewJackson(JacksonTest.java:21)
```
