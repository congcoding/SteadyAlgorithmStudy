from itertools import combinations

def isPrime(num):
    for i in range(2, num):
        if num % i == 0:
            return False
    return True

def solution(nums):
    answer = 0
    
    com = list(combinations(nums, 3))
    for i in com:
        if isPrime(sum(i)):
            answer += 1

    return answer
