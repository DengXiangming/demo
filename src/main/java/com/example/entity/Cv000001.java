package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * {"tableRemake":"","tableCnName":"文档类别代码","category":"电子病历值域","tableEnName":"CV000001","tableCategory":""}
 * </p>
 *
 * @author Bean
 * @since 2019-11-20
 */
@TableName("CV000001")
public class Cv000001 extends Model<Cv000001> {

    private static final long serialVersionUID = 1L;

    /**
     * 标准表主键
     */
    @TableId(value = "dic_id", type = IdType.AUTO)
    private Integer dicId;

    /**
     * 来源
     */
    private String dicSource;

    /**
     * 值
     */
    private String dicCode;

    /**
     * 值含义
     */
    private String dicValue;

    /**
     * 备注说明
     */
    private String dicComment;

    /**
     * 类别
     */
    private String dicCategory;

    private LocalDateTime dicGct;

    private LocalDateTime dicGmt;

    /**
     * 主表规则id
     */
    private String versionId;

    /**
     * 主表数据表版本号
     */
    private Integer version;


    public Integer getDicId() {
        return dicId;
    }

    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }

    public String getDicSource() {
        return dicSource;
    }

    public void setDicSource(String dicSource) {
        this.dicSource = dicSource;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public String getDicComment() {
        return dicComment;
    }

    public void setDicComment(String dicComment) {
        this.dicComment = dicComment;
    }

    public String getDicCategory() {
        return dicCategory;
    }

    public void setDicCategory(String dicCategory) {
        this.dicCategory = dicCategory;
    }

    public LocalDateTime getDicGct() {
        return dicGct;
    }

    public void setDicGct(LocalDateTime dicGct) {
        this.dicGct = dicGct;
    }

    public LocalDateTime getDicGmt() {
        return dicGmt;
    }

    public void setDicGmt(LocalDateTime dicGmt) {
        this.dicGmt = dicGmt;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.dicId;
    }

    @Override
    public String toString() {
        return "Cv000001{" +
        "dicId=" + dicId +
        ", dicSource=" + dicSource +
        ", dicCode=" + dicCode +
        ", dicValue=" + dicValue +
        ", dicComment=" + dicComment +
        ", dicCategory=" + dicCategory +
        ", dicGct=" + dicGct +
        ", dicGmt=" + dicGmt +
        ", versionId=" + versionId +
        ", version=" + version +
        "}";
    }
}
