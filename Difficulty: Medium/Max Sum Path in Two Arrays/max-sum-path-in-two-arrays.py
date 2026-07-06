class Solution:
    def maxPathSum(self, a, b):
        i,j=0,0
        sum1,sum2=0,0
        result=0
        
        while(i< len(a) and j<len(b)):
            if a[i]<b[j]:
                sum1+=a[i]
                i+=1
            elif b[j]<a[i]:
                sum2+=b[j]
                j+=1
            else:
                result+=max(sum1,sum2) + a[i]
                sum1, sum2 = 0, 0
                i+=1
                j+=1
        
        while(i<len(a)):
            sum1+=a[i]
            i+=1
        while(j<len(b)):
            sum2+=b[j]
            j+=1
        result+=max(sum1,sum2)
        return result
        
        