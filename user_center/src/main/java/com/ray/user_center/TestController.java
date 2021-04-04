package com.ray.user_center;

import com.ray.user_center.domain.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张烈文
 */
@RestController
public class TestController {


    @GetMapping("/q")
    public User test(User user) {
        return user;
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.toString().toCharArray();
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    public static int[] searchRange(int[] nums, int target) {

        if(nums.length==0){
            return new int[]{-1,-1};
        }

        int start=findFirst(nums,target);
        if(start==-1){
            return new int[]{-1,-1};
        }

        int end=findLast(nums,target);

        return new int[]{start,end};

    }


    private static int findFirst(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>target){
                r=mid-1;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }

        return (nums[l]==target)?l:-1;
    }

    private static int findLast(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>target){
                r=mid-1;
            }else if(nums[mid]==target){
                l = mid ;
            }else{
                l=mid+1;
            }
        }
        return (nums[r]==target)?r:-1;
    }
}
