class Solution:
    def bin_addr(self,arr,num,start,end):
        while start<=end:
            if len(arr)==1:
                if arr[start]<=num:
                    return start+1
                else:
                    return start
            else:
                mid=(start+end)//2
                #print(mid)
                if arr[mid]<num:
                    return Solution.bin_addr(self,arr,num,mid+1,end)
                if arr[mid]==num:
                    return mid+1
                if arr[mid]>num:
                    return Solution.bin_addr(self,arr,num,start,mid-1)
        return start

    def countSmaller(self, nums: List[int]) -> List[int]:
        #print("length of nums ",len(nums))
        if len(nums)==0:
            return []
        res=[0 for i in range(len(nums))]
        a=[nums[-1]]
        for i in range(len(nums)-2,-1,-1):
            start=0
            end=len(a)-1
            pos=Solution.bin_addr(self,a,nums[i],start,end)
            a.insert(pos,nums[i])
            res[i]=a.index(nums[i])
        return res


            
