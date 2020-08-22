package com.zhk.entity.vo;

import java.util.List;

/**
 * @author 赵洪苛
 * @date 2020/8/22 16:23
 * @description 资源视图对象
 */
public class ResourceVo {

    private String title;
    private String key;
    private Boolean isLeaf;
    private List<ResourceVo> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public List<ResourceVo> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ResourceVo{" +
                "title='" + title + '\'' +
                ", key='" + key + '\'' +
                ", isLeaf=" + isLeaf +
                ", children=" + children +
                '}';
    }
}
