def solution(absolutes, signs):
    answer = 0
    for index, value in enumerate(signs):
        if value == False:
            answer += absolutes[index] * (-1)
        else:
            answer += absolutes[index]
            
    return answer
