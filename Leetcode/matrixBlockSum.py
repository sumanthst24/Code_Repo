class Solution:
    def matrixBlockSum(self, mat: List[List[int]], K: int) -> List[List[int]]:
        answer=[]
        for i in range(len(mat)):
            temp=[]
            for j in range(len(mat[i])):
                total=0
                rleft=i-K
                if i-K<0:
                    rleft=0
                rright=i+K
                if rright>=len(mat):
                    rright=len(mat)-1
                cleft=j-K
                if j-K<0:
                    cleft=0
                cright=j+K
                if cright>=len(mat[i]):
                    cright=len(mat[i])-1
                for r in range(rleft,rright+1):
                    total+=sum(mat[r][cleft:cright+1])
                temp.append(total)
            answer.append(temp)
        return answer
        
