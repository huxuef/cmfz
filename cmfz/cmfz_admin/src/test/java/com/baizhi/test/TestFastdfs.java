package com.baizhi.test;

import com.baizhi.cmfz.Application;
import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestFastdfs {

    @Autowired
    private FastFileStorageClient client;
    /**
     * 文件上传
     */
    @Test
    public void testUpload() throws Exception {
        File file = new File("E:\\upload\\IMG_20160526_133538.jpg");
        FileInputStream fi = new FileInputStream(file);
        Set set = new HashSet<MataData>();
        set.add(new MataData());
        StorePath storePath = client.uploadFile(fi, file.length(), "jpg", set);
        System.out.println(storePath.getGroup()+" | "+storePath.getPath());
    }
    /**
     * 文件下载
     */
    @Test
    public void testDownload() throws Exception {
        byte[] downloadFile = client.downloadFile("group1", "M00/00/00/wKiDgVug7YGAawpCAFsVRVXEByE592.jpg",
                new DownloadByteArray());
        FileOutputStream fot = new FileOutputStream("E:\\upload\\01.jpg");
        fot.write(downloadFile);
        fot.close();
    }
}
