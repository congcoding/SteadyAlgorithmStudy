def solution(board, moves):
    answer = 0
    bucket = []
    for move in moves:
        for doll in board:
            if doll[move - 1] != 0:
                bucket.append(doll[move - 1])
                doll[move - 1] = 0
                if len(bucket) > 1:
                    if bucket[-1] == bucket[-2]:
                        answer += 2
                        bucket = bucket[:-2]
                break

    return answer
