package com.lily.administrator.slidetodelete;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2017/11/30.
 */

public class DateEntity implements Comparable<DateEntity>{
    String content;
    boolean canDelete;

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    @Override
    public String toString() {
        return "DateEntity{" +
                "content='" + content + '\'' +
                ", canDelete=" + canDelete +
                '}';
    }


    @Override
    public int compareTo(@NonNull DateEntity o) {
        if (o==null)return -1;

        return o.getContent().equals(content)?0:-1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null)return false;
        DateEntity dateEntity= (DateEntity) obj;
        return content.equals(dateEntity.getContent());
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
