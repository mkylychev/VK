
package com.vkappkg.vk.vk.model.attachment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vkappkg.vk.vk.model.Photo;

public class ApiAttachment {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("photo")
    @Expose
    private Photo photo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

}