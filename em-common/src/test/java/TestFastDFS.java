import common.util.FastDFSClient;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zj on 2017/6/29.
 */
public class TestFastDFS {

    @Test
    public void testFast() {
        try {
            //创建一个配置文件 存放tracker服务的地址
            //使用全局对象加载配置文件
            ClientGlobal.init("E:/code/SOA/em-common/src/main/resources/conf/client.conf");

            //创建一个TrackerClient对象
            TrackerClient trackerClient = new TrackerClient();

            //获取TrackerServer对象
            TrackerServer trackerServer = trackerClient.getConnection();

            //创建一个StorageServer的引用(可null)
            StorageServer storageServer = null;

            //创建一个StorageClient,参数需要TrackerServer和StorageServer
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);

            //使用StorageClient上传文件
            String str[] = storageClient.upload_file("E:/code/SOA/em-common/src/main/resources/conf/img.jpg", "jpg", null);
            for (String s : str) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFastUtil() {
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("E:/code/SOA/em-common/src/main/resources/conf/client.conf");
            String str = fastDFSClient.uploadFile("E:/code/SOA/em-common/src/main/resources/conf/img.jpg");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
