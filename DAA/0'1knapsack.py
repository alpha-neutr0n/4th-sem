# Program for 0-1 Knapsack problem
# Returns the maximum value that can be put in a knapsack of capacity W
def knapSack(W, wt, val, n):
    K = [[0 for x in range(W + 1)] for x in range(n + 1)]

    # Build table K[][] in bottom up manner
    for i in range(n + 1):
        for w in range(W + 1):
            print()
            print("v[{},{}] = ".format(i, w), end="")
            if i == 0 or w == 0:
                K[i][w] = 0
                print("0")


            elif wt[i - 1] <= w:

                K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w])
                print("max(val[{i1}] + K[{i1}][w-wt[{i1}]], K[{i1}][{w}]) ".format(i1=i - 1, w=w))

                print("v[{},{}] = ".format(i, w), end="")
                print("max(val[{i1}] + K[{i1}][{wwt}], K[{i1}][{w}]) ".format(i1=i - 1, w=w, wwt=w - wt[i - 1]))

                print(">> v[{},{}] = ".format(i, w), end="")
                print("max({data} + K[{i1}][{wwt}], K[{i1}][{w}]) ".format(data=val[i - 1], i1=i - 1, w=w,
                                                                           wwt=w - wt[i - 1]))

                print("v[{},{}] = ".format(i, w), end="")
                print("max({} + {}, {}) = {}".format(val[i - 1], K[i - 1][w - wt[i - 1]], K[i - 1][w], K[i][w]))
            else:
                K[i][w] = K[i - 1][w]
                print("v[{},{}] = {}".format(i - i, w, K[i - 1][w]))
    print()
    for items in K:
        print(items)
    return K[n][W]


# Driver program to test above function
wt = [3,2,1,4,5]        # Give the weights of the objects
val = [25,20,15,40,50]  # Give the respective profits
W = 6                   # Enter the maximum knapsack weight
n = len(val)
print(knapSack(W, wt, val, n))
