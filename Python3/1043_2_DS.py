# https://www.acmicpc.net/problem/1043
# 20201104

import sys

class Disjoint_Set:
    def __init__(self, N_items):
        self.items = [i for i in range(N_items + 1)]

    def union(self, idx1, idx2):
        root1, rank1 = self.find(idx1, 0)
        root2, rank2 = self.find(idx2, 0)

        if root1 == root2:
            return

        elif root1 == 0:
            self.items[root2] = self.items[root1]

        elif root2 == 0:
            self.items[root1] = self.items[root2]

        elif rank1 >= rank2:
            self.items[root2] = self.items[root1]

        else:
            self.items[root1] = self.items[root2]

    def find(self, idx, rank):
        if self.items[idx] == idx:
            return idx, rank

        else:
            return self.find(self.items[idx], rank + 1)


if __name__ == "__main__":
    N_person, N_party = map(int, sys.stdin.readline().split())
    DS = Disjoint_Set(N_person)

    T_people = list(map(int, sys.stdin.readline().split()))
    N_Tperson = T_people[0]
    T_people = T_people[1:]


    parties = []
    for T_person in T_people:
        DS.union(0, T_person)

    for _ in range(N_party):
        party_people = list(map(int, sys.stdin.readline().split()))
        N_party_people = party_people[0]
        party_people = party_people[1:]

        parties.append(party_people)

        for i in range(len(party_people) - 1):
            DS.union(party_people[i], party_people[i+1])

    if N_Tperson == 0:
        print(N_party)
        exit()


    T_people = []
    for i in range(1, N_person + 1):
        if DS.find(i, 0)[0] == 0:
            T_people.append(i)

    F_party = 0
    F_flag = 1
    for party in parties:
        for party_person in party:
            if party_person in T_people:
                F_flag = 0
                break

        if F_flag == 1:
            F_party += 1

        F_flag = 1


    print(F_party)
