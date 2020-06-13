## 简单通过记录次数在文件中，限制接口访问次数，不引入redis
见`com.bkunzh.Controller.FileController.downloadFile`
```java
    /**
         * 限制接口请求次数，超过一定次数就不让访问了
         */
    @Async
    public void countCallInterface() {
        synchronized (FileController.class) {
            fileExists();
            String countStr = FileUtil.readFileAsStr(countFile);
            if (countStr == null || countStr.trim().isEmpty()) {
//                FileUtil.writeStrToFile(countFile, String.valueOf(count));
            } else {
                int count0 = Integer.valueOf(countStr);
                count = Math.max(count0, count);
            }
            ++count;
            FileUtil.writeStrToFile(countFile, String.valueOf(count));
        }
    }
```