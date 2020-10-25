# https://www.acmicpc.net/problem/1019
# 20201024

import sys

# Maximum number of exponent where base is 10
MAX_EXP = 10

# list of 10^n
exp_of_10 = [10 ** exp for exp in range(MAX_EXP + 1)]

# The number of 'each' digit between 0000...0 ~ 9999...9
digits_under_exp_of_10 = [(10 ** exp) * (exp + 1) for exp in range(MAX_EXP + 1)]

# The number of number which the first digit is zero and second digit is nonzero
# ex) [The number of 01...09, The number of 010...099, ... ]
# First of this list must be 1, because "0" can only satisfy condition
nonzero_under_exp_of_10 = [exp_of_10[i + 1] - exp_of_10[i] for i in range(len(exp_of_10) - 1)]
nonzero_under_exp_of_10.insert(0, 1)


# Add second list to the first list
def list_sum(list1, list2):
    assert len(list1) == len(list2)

    for i in range(len(list1)):
        list1[i] += list2[i]


# Subtract second list to the first list
def list_minus(list1, list2):
    assert len(list1) == len(list2)

    for i in range(len(list1)):
        list1[i] -= list2[i]


# Count every digits between 1 to given number
def cnt_digits(number):
    # Tokenize the number and save it
    number_list = []
    # Records how many digits were appeared
    digit_list = [0] * 10

    # Tokenize the number by repeatedly dividing by 10
    copy_number = number
    while copy_number != 0:
        digit = copy_number - ((copy_number // 10) * 10)
        number_list.insert(0, digit)

        digit_list[digit] += 1      # This must be considered because the input number is not calculated at below

        copy_number //= 10

    # Indicates how long the number is ex) number : 1234, max_exp : 4
    max_exp = len(number_list)

    # In this for loop, by repeatedly cutting the number, it calculates how many digits were appeared
    # We use the exponent as index, from 0 to max_exp - 1
    for cur_exp in range(max_exp):

        # Cutting is proceed by removing the remainder of 10^n
        # 7542 -> 7540 -> 7500 -> 7000 -> 0000
        cut_number = number  - (number % exp_of_10[cur_exp + 1])

        # Calculates how many numbers between original number and cut number
        # This difference will be used to calculate the upper level of digit
        cnts = (number - cut_number)

        # The digits that have higher index than current place
        upper_numbers = number_list[:max_exp - cur_exp - 1]

        # The current digit that we are looking for
        cur_number = number_list[max_exp - cur_exp - 1]

        # If there is no difference between numbers and cut one, it does not require calculation
        if cnts == 0:
            continue

        # For the digits which is upper than current exponent, cnts will be added.
        for upper_number in upper_numbers:
            digit_list[upper_number] += cnts

        # If the current digit is I, then 0, 1, ... ,I-1 digit must add the 10 ^ (current exponent)
        for und_cur_number in range(cur_number):
            digit_list[und_cur_number] += exp_of_10[cur_exp]

        # If the current exponent is not zero, than digits of lower exponent must be add
        # That is exactly same with (digits_under_exp_of_10) * (current digit)
        if cur_exp != 0:
            list_sum(digit_list, [digits_under_exp_of_10[cur_exp - 1] * cur_number] * 10)

        # Cut the number and repeat this procedure
        number = cut_number

    # Delete the cases where the first digit is starts from 0
    # ex) 0000, 0001, ..., 0999
    deleted_list = [0] * 10

    # Divide cases as 000...0, 000...#, 0##...# => Use "nonzero_under_exp_of_10" list
    for del_exp in range(max_exp):
        deleted_list[0] += ((del_exp + 1) * (nonzero_under_exp_of_10[max_exp - del_exp - 1]))

    list_minus(digit_list, deleted_list)

    return digit_list


if __name__ == "__main__":
    input_N = int(sys.stdin.readline().rstrip())

    result = cnt_digits(input_N)
    for res in result:
        print(res, end=' ')

