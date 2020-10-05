## Spring Profile
有些Bean不同环境希望不一样，可以增加@Profile("xx")指定这个Bean是在xx环境才会加载到spring容器，然后运行时指定jvm参数 -Dspring.profiles.active=dev
```
    @Profile("dev")
    @Bean("myMap")
    public Map<String, Object> devMap() {
        Map<String, Object> tMap = new HashMap<>();
        tMap.put("aa", "dev");
        return tMap;
    }

    @Profile("test")
    @Bean("myMap")
    public Map<String, Object> testMap() {
        Map<String, Object> tMap = new HashMap<>();
        tMap.put("aa", "test");
        return tMap;
    }
```