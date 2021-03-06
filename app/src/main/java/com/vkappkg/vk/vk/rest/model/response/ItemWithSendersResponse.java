package com.vkappkg.vk.vk.rest.model.response;

import com.vkappkg.vk.vk.model.Group;
import com.vkappkg.vk.vk.model.Owner;
import com.vkappkg.vk.vk.model.Profile;

import java.util.ArrayList;
import java.util.List;

public class ItemWithSendersResponse<T> extends BaseItemResponse<T>  {
    private List<Profile> profiles = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    private List<Profile> getProfiles(){
        return profiles;
    }

    private List<Group> getGroups() {
        return groups;
    }

    private List<Owner> getAllSenders(){
        List<Owner> all = new ArrayList<>();
        all.addAll(getProfiles());
        all.addAll(getGroups());
        return all;
    }

    public Owner getSenders(int id){
        for (Owner owner: getAllSenders()){
            if(owner.getId() == Math.abs(id)){
                return owner;
            }
        }
        return null;
    }

}
