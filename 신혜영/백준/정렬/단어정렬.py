cnt = int(input())
word_arr = []
for i in range(cnt):
    word = input()
    if word not in word_arr:
        word_arr.append(word)

word_arr = sorted(word_arr)
word_arr = sorted(word_arr, key=len)

for word in word_arr:
    print(word)
