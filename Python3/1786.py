import sys

def get_restart_idxs(arr):
    # Stores the restart idxs
    restart_idxs = [-1]
    restart_idx = 0

    for idx in range(len(arr)):
        # If first word does not match, then start from the first 
        if idx == 0:
            restart_idxs.append(0)
            continue
        
        # If nth word does not match
        if arr[idx] != arr[restart_idx]:

            # Find a restart index recursively
            while arr[idx] != arr[restart_idx]:
                restart_idx = restart_idxs[restart_idx]
                
                # If a word is not matched to everything
                if restart_idx < 0: break

        restart_idx += 1
        restart_idxs.append(restart_idx)
    
    return restart_idxs

def get_sub_idxs(total_string, sub_string):
    restart_idxs = get_restart_idxs(sub_string)
    sub_idx = 0
    ptr_idx = 0
    sub_idxs = []

    while ptr_idx < len(total_string):
        if total_string[ptr_idx] != sub_string[sub_idx]:
            if sub_idx == 0:
                ptr_idx += 1
            else:
                sub_idx = restart_idxs[sub_idx]
        
        else:
            ptr_idx += 1
            sub_idx += 1

        if sub_idx == len(sub_string):
            sub_idxs.append(ptr_idx - sub_idx)
            sub_idx = restart_idxs[sub_idx]

    return sub_idxs

if __name__ == "__main__":
    total_string = sys.stdin.readline().strip('\n')
    sub_string = sys.stdin.readline().strip('\n')

    sub_idxs = get_sub_idxs(total_string, sub_string)

    print(len(sub_idxs))
    for idx in sub_idxs:
        print(idx + 1, end=" ")
