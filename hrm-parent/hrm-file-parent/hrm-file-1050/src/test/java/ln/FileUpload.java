package ln;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUpload {
    @Test
    public void uploadTest() throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "LTAI4GA3K3kXxxCuHx6ejizP";
        String accessKeySecret = "GHCxzwaReZGNERYtiNssX06yfst1OI";
        String bucketName = "hrm-ln";
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = "hr-image/wwdc21_hero2.jpg";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
        String content = "F:/wwdc21_hero.jpg";
//        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
        ossClient.putObject(bucketName, objectName, new FileInputStream(content));

// 关闭OSSClient。
        ossClient.shutdown();
    }
}
