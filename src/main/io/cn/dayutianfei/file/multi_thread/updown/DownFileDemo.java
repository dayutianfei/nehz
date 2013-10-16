package cn.dayutianfei.file.multi_thread.updown;

public class DownFileDemo {  
    public DownFileDemo() {  
        try { 
        	long s = System.currentTimeMillis();
            DownFileInfoBean bean = new DownFileInfoBean(  
                    "http://archive.cloudera.com/cdh4/cdh/4/flume-ng-1.3.0-cdh4.2.1.tar.gz", 
                    "/Users/dayutianfei/temp",  
                    "flume.tar.gz", 7,true,null);  
            /*File file = new File("D:\\dan07.apk"); 
            DownFileInfoBean bean = new DownFileInfoBean(null, "D:\\temp", 
                    "dan07.apk", 3,false,file);*/  
            DownFileFetch fileFetch = new DownFileFetch(bean);  
            fileFetch.start();  
            System.out.println(System.currentTimeMillis()-s);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String[] args) {  
        new DownFileDemo();  
    }  
}  
