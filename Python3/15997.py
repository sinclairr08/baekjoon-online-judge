# https://www.acmicpc.net/problem/15997
# 20201124

import sys

unpack = [(0, 1), (0, 2), (0, 3), (1, 2), (1, 3), (2, 3)]
pack = [-1, 0, 1, 2, 3, 4, -1, 5]


def get_points_as_index(index):
    results = []
    points = [[0, i] for i in range(4)]
    for _ in range(6):
        results.append(index % 3)
        index //= 3

    results.reverse()
    for i, result in enumerate(results):
        con_1, con_2 = unpack[i]

        if result == 0:
            points[con_1][0] += 3
        elif result == 1:
            points[con_1][0] += 1
            points[con_2][0] += 1
        elif result == 2:
            points[con_2][0] += 3

    points.sort(key=lambda x:x[0], reverse=True)
    return points


if __name__ == "__main__":
    conturies = sys.stdin.readline().split()
    predicts = [[] for _ in range(6)]


    for _ in range(6):
        line = sys.stdin.readline().split()

        # sort as (AB, AC, AD, BC, BD, CD)
        con_1, con_2 = conturies.index(line[0]), conturies.index(line[1])
        if con_1 > con_2:
            con_2, con_1 = con_1, con_2
            predict = list(map(float, reversed(line[2:])))

        else:
            predict = list(map(float, line[2:]))

        idx = pack[2 * con_1 + con_2]

        predicts[idx] = predict

    event_probs = [ res1 * res2 * res3 * res4 * res5 * res6
                    for res1 in predicts[0]
                    for res2 in predicts[1]
                    for res3 in predicts[2]
                    for res4 in predicts[3]
                    for res5 in predicts[4]
                    for res6 in predicts[5]
    ]

    total_probs = [.0] * 4

    for idx, prob in enumerate(event_probs):
        if prob == 0:
            continue

        pts = get_points_as_index(idx)

        if pts[0][0] == pts[1][0] == pts[2][0] == pts[3][0]:
            for i in range(4):
                total_probs[i] += prob / 2
        elif pts[0][0] == pts[1][0] == pts[2][0]:
            total_probs[pts[0][1]] += 2 * prob / 3
            total_probs[pts[1][1]] += 2 * prob / 3
            total_probs[pts[2][1]] += 2 * prob / 3
        elif pts[1][0] == pts[2][0] == pts[3][0]:
            total_probs[pts[0][1]] += prob
            total_probs[pts[1][1]] += prob / 3
            total_probs[pts[2][1]] += prob / 3
            total_probs[pts[3][1]] += prob / 3
        elif pts[1][0] == pts[2][0]:
            total_probs[pts[0][1]] += prob
            total_probs[pts[1][1]] += prob / 2
            total_probs[pts[2][1]] += prob / 2
        else:
            total_probs[pts[0][1]] += prob
            total_probs[pts[1][1]] += prob

    for total_prob in total_probs:
        print(total_prob)
