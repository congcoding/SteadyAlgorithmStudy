def solution(numbers):
    answer = 0
    result = [0] * 10
    for num in numbers:
        result[num] += 1

    for index, value in enumerate(result):
        if value != 1:
            answer += index
    return answer
