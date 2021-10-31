def solution(clothes):
    hash = {}
    answer = 1
    for key, value in clothes:
        if value in hash:
            hash[value] += 1
        else:
            hash[value] = 1

    for value in hash.values():
        answer *= value + 1
    return answer - 1
