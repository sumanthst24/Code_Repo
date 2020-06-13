#include<iostream>
using namespace std;

int calWaterQt(int arr[],int n){
    int waterQt=0;
    int left[n],right[n];
    left[0]=arr[0];
    right[n-1]=arr[n-1];
    for(int i=1;i<n;i++){
        left[i]=max(left[i-1],arr[i]);
    }
    for(int i=n-2;i>=0;i--){
        right[i]=max(right[i+1],arr[i]);
    }
    for(int i=0;i<n;i++){
        waterQt+=min(left[i],right[i])-arr[i];
    }
    return waterQt;
}
int calWaterQtOpt(int arr[],int n){
    int waterQt=0;
    int left=0,right=0,low=0,high=n-1;
    while(low<=high){
        if(arr[low]<arr[high]){
            if(arr[low]<left){
                waterQt+=left-arr[low];
            }
            else{
                left=arr[low];
            }
            low++;
        }
        else{
            if(arr[high]<right){
                waterQt+=right-arr[high];
            }
            else{
                right=arr[high];
            }
            high--;
        }
    }
    return waterQt;
}
int main(){
    int n;
    cin>>n;
    int ar[n];
    for(int i=0;i<n;i++)cin>>ar[i];
    cout<<"water holded is : "<<calWaterQtOpt(ar,n);
return 0;
}
