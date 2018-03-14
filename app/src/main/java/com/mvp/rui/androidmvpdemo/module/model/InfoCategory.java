package com.mvp.rui.androidmvpdemo.module.model;


import com.google.gson.annotations.SerializedName;
import com.mvp.rui.androidmvpdemo.common.network.basemodel.BaseModel;

/**
 * 首页头部本地数据表
 */
//@Entity
public class InfoCategory extends BaseModel {

    public static final int TYPE_MY = 1;
    public static final int TYPE_OTHER = 2;
    public static final int TYPE_MY_CHANNEL = 3;
    public static final int TYPE_OTHER_CHANNEL = 4;

    public InfoCategory(int itemType, String title, long categoryId, String remark) {
        this.itemType = itemType;
        this.title = title;
        this.categoryId = categoryId;
        this.remark = remark;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    private int itemType;


//    @Override
//    public int getItemType() {
//        return itemType;
//    }

    /****************************以下为数据库配置******************************************/

    private static final long serialVersionUID = 0x2;

//    @Id
    private Long id;

    /**
     * 类别ID与服务器返回的id对应
     * 栏目id ,
     */
    @SerializedName("catId")
    private Long categoryId;

    /**
     * 标题
     * 栏目名称
     */
    @SerializedName("catName")
    private String title;

    /**
     * 类别，区分：已使用、未使用（推荐）
     * type (string, optional): 栏目类型：我的/默认----MY/DF
     */
    @SerializedName("type")
    private String typeGroup;
    /**
     * 排序号：有排序时可用
     */
    @SerializedName("seqNum")
    private int seqNum;
    /**
     * 类别，区分： 推荐、求购、普通资讯
     * 推荐/热点 /图片/视频 /求购/------rec/hot/pic/vdo/buy/
     */
    @SerializedName("code")
    private String type;
    /**
     * 本地创建者ID
     */
    private String createId;
    /**
     * 备注
     */
    private String remark;

    public InfoCategory() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeGroup() {
        return this.typeGroup;
    }

    public void setTypeGroup(String typeGroup) {
        this.typeGroup = typeGroup;
    }

    public int getSeqNum() {
        return this.seqNum;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateId() {
        return this.createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InfoCategory that = (InfoCategory) o;

        return categoryId != null ? categoryId.equals(that.categoryId) : that.categoryId == null;

    }

    @Override
    public int hashCode() {
        return categoryId != null ? categoryId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "InfoCategory{" +
                "itemType=" + itemType +
                ", id=" + id +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", typeGroup='" + typeGroup + '\'' +
                ", seqNum=" + seqNum +
                ", type='" + type + '\'' +
                ", createId='" + createId + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
