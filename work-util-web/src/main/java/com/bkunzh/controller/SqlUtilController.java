package com.bkunzh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bingkun_zhang
 * @date 2020/6/17
 */
@RestController
@RequestMapping("/sqlUtil")
public class SqlUtilController {
    /* 查询结果导出的sql
    INSERT INTO `` VALUES (838673, '13651118888', 'Bernice', NULL, NULL, '1', NULL, NULL, NULL, '13651118888', NULL, 'ed98277f-9849-4b3a-a5c5-15952c9142db', NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, 1, '19415095', '5ee6e3fde4b06780eb487774', '2020-6-15 10:59:10', 0, NULL, 0, '2143391');
        INSERT INTO `t_bd_user`(name,nickName,fullName,idNo,gender,birthDate,avatar,email,phone,kdUid,kdCloudToken,icloudId,icloudPassword,icloudExtId,icloudOpenId,sourceEid,inviteUserId,qqOpenId,qqNickName,role,eId,accoutICloudId,joinTime,noSend,orgJoinTime,channelId,openEid)
         VALUES ('13651118888', 'Bernice', NULL, NULL, '1', NULL, NULL, NULL, '13651118888', NULL, 'ed98277f-9849-4b3a-a5c5-15952c9142db', NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, 1, '19415095', '5ee6e3fde4b06780eb487774', '2020-6-15 10:59:10', 0, NULL, 0, '2143391');

     */
    /**
     * 通过表定义语句列定义部分，返回insert列定义，如(col1,col2,col3)
     * @param partTableDDL create表语句，列定义部分
     * @return
     */
    @RequestMapping("/generateInsertCols")
    public String generateInsertCols(@RequestBody String partTableDDL) {
        String[] lines = partTableDDL.split("\n");
        StringBuilder insertTableColumnStr = new StringBuilder("(");
        for (String line : lines) {
//            insertTableColumnStr.append(line.split("`")[1].split("`")[0] + ",");
            insertTableColumnStr.append(line.split("`")[1] + ",");
        }
        insertTableColumnStr.delete(insertTableColumnStr.length() - 1, insertTableColumnStr.length());
        insertTableColumnStr.append(")");
        return insertTableColumnStr.toString();
    }
}
