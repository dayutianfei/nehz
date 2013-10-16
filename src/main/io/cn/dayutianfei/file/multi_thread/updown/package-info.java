/**
 * 用于文件的多线程上传和下载
 * 模块假定的应用场景：
 * 1.通用的网络访问场景；
 * 2.不使用任何第三方的插件；
 * 3.不使用额外的资源进行数据的缓存，如数据库；
 * 4.高速可靠的运行场景；
 */
/**
 * @author dayutianfei
 * DownFileInfoBean:存储下载文件的相关信息
 * DownFileUtility:下载文件的工具类
 * DownFileAccess:每个线程处理的部分文件
 * DownFileSplitterFetch:处理当前线程分配的文件下载工作
 * DownFileFetch:多线程下载的主要工作类
 */
package cn.dayutianfei.file.multi_thread.updown;