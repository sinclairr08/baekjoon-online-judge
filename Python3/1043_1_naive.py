# https://www.acmicpc.net/problem/1043
# 20201104

import sys

if __name__ == "__main__":
    N_person, N_party = map(int, sys.stdin.readline().split())
    T_people = list(map(int, sys.stdin.readline().split()))
    N_Tperson = T_people[0]
    T_people = T_people[1:]

    parties = []
    adj_graph = [[0] * (N_person + 1) for _ in range(N_person + 1)]

    for i in range(N_party):
        party_people = list(map(int, sys.stdin.readline().split()))
        N_party_people = party_people[0]
        party_people = party_people[1:]

        for i in party_people:
            for j in party_people:
                if i != j:
                    adj_graph[i][j] = 1

        parties.append(party_people)
        del party_people

    if N_Tperson == 0:
        print(N_party)
        exit()

    T_con_people = []
    for tp in T_people:
        if tp not in T_con_people:
            T_con_people.append(tp)

        connected = [i for i in range(1, N_person + 1) if adj_graph[tp][i] == 1]
        for con in connected:
            if con not in T_people and con not in T_con_people:
                T_people.append(con)

    F_flag = True
    F_party = 0
    for party in parties:
        for party_one in party:
            if party_one in T_con_people:
                F_flag = False

        if F_flag:
            F_party += 1

        F_flag = True

    print(F_party)