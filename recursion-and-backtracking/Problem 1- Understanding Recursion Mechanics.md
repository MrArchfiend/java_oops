
---

## **Question**

You are developing a file size calculator for a cloud storage system. The system needs to calculate the total size of a directory, which may contain files and subdirectories.

  

Given the directory structure:

```
project/
├── src/
│   ├── main.java (100 KB)
│   └── utils.java (50 KB)
├── docs/
│   ├── readme.txt (10 KB)
│   └── guides/
│       └── setup.pdf (200 KB)
└── config.xml (20 KB)
```

Answer the following:

  

**a)** Design a recursive function (pseudocode) to calculate total directory size. Identify base and recursive cases.

**b)** Trace the execution and show the call stack and returned values.

**c)** Find the time complexity.

**d)** Can it be solved iteratively? Compare both approaches.

**e)** What if a symbolic link creates a cycle? How will you handle it?

---

## **Solution**

  

### **a) Recursive Function Design**

  

**Pseudocode:**

```
function getSize(node):
    if node is a file:
        return node.size        // Base case

    total = 0
    for each child in node:
        total = total + getSize(child)   // Recursive case
    return total
```

**Base Case:**

- When the node is a file, return its size.
    

  

**Recursive Case:**

- When the node is a directory, recursively compute size of all children.
    

---

### **b) Execution Trace**

```
getSize(project)
 ├── getSize(src)
 │    ├── getSize(main.java) → 100
 │    └── getSize(utils.java) → 50
 │    src returns 150
 ├── getSize(docs)
 │    ├── getSize(readme.txt) → 10
 │    └── getSize(guides)
 │         └── getSize(setup.pdf) → 200
 │         guides returns 200
 │    docs returns 210
 └── getSize(config.xml) → 20
project returns 380 KB
```

**Total Directory Size = 380 KB**

---

### **c) Time Complexity**

  

Let **N** be total files and directories.

  

\text{Time Complexity} = O(N)

  

Each file and directory is visited once.

---

### **d) Iterative Solution**

  

Yes, it can be solved iteratively.

  

**Data Structure Used:**

- Stack (DFS) or Queue (BFS)
    

  

**Comparison:**

|**Recursive**|**Iterative**|
|---|---|
|Simple to write|Avoids stack overflow|
|Uses call stack|Uses explicit stack|
|Risky for deep trees|Safer for large systems|

---

### **e) Symbolic Link Cycle Problem**

  

**Issue:**

- Cycles cause infinite recursion.
    

  

**Solution:**

- Maintain a visited set.
    
- If a directory is already visited, return 0.
    

  

This prevents infinite loops.

---

# **Problem 2: Backtracking Template Application**

  

## **Question**

  

A word puzzle game uses a 4×4 grid. Letters can be connected horizontally, vertically, or diagonally, and each letter can be used only once.

  

Grid:

```
C A T S
O R E A
D E A M
E L L S
```

Target Word: **DREAM**

  

Answer:

  

**a)** Design a backtracking algorithm (pseudocode).

**b)** Show the decision tree for finding “DREAM”.

**c)** Trace execution and backtracking steps.

**d)** Find worst-case time complexity.

**e)** How to find ALL possible ways to form the word?

---

## **Solution**

  

### **a) Backtracking Algorithm**

```
function search(r, c, index):
    if index == word.length:
        return true

    if out of bounds OR visited[r][c] OR grid[r][c] != word[index]:
        return false

    mark visited[r][c] = true

    for each of 8 directions:
        if search(next_r, next_c, index + 1):
            return true

    visited[r][c] = false   // Backtracking
    return false
```

**State:** position and current index

**Choices:** 8 directions

**Constraint:** no repeated cell

**Goal:** full word matched

---

### **b) Decision Tree**

```
D → R → E → A → M ✓
```

Other branches fail and backtrack.

---

### **c) Execution Trace**

1. Start at **D**
    
2. Move to **R**
    
3. Move to **E**
    
4. Move to **A**
    
5. Move to **M** → success
    
6. Backtracking stops
    

---

### **d) Time Complexity**

  

Let grid = N × M, word length = L

  

O(N × M × 8^L)

---

### **e) Finding ALL Paths**

  

**Modification:**

- Remove early return
    
- Store valid paths
    

  

**Extra Data Structure:**

- List or counter for solutions
    

---

# **Problem 3: N-Queens Optimization and Variants**

  

## **Question**

  

An application implements N-Queens using backtracking.

  

Answer:

  

**a)** Calculate search space sizes for 8-Queens.

**b)** Design optimized solution using 1D array and diagonals.

**c)** Trace solution for N = 4.

**d)** Modify algorithm to find only ONE solution quickly.

**e)** How to handle forbidden squares?

---

## **Solution**

  

### **a) Search Space (8-Queens)**

- **Brute Force:**
    
    64^8
    
- **One queen per row:**
    
    8^8 = 16,777,216
    
- **Backtracking (approx.):**
    
    ~15,000–20,000 states explored due to pruning
    

---

### **b) Optimized Algorithm**

```
board[n]
col[n], diag1[2n], diag2[2n]

function place(row):
    if row == n:
        print solution
        return

    for c = 0 to n-1:
        if not col[c] and not diag1[row+c] and not diag2[row-c+n]:
            board[row] = c
            mark col, diag1, diag2
            place(row + 1)
            unmark col, diag1, diag2
```

**Optimization:**

- O(1) conflict checking
    
- No board scanning
    

---

### **c) Trace for N = 4**

```
Row 0 → Col 1
Row 1 → Col 3
Row 2 → Col 0
Row 3 → Col 2 ✓
```

Solution: [1, 3, 0, 2]

---

### **d) Finding Only One Solution**

- Stop recursion after first solution
    
- Return boolean instead of printing all
    
- Use column ordering heuristics
    

---

### **e) Forbidden Squares**

  

**Modification:**

- Skip forbidden cells before placing queen
    

```
if forbidden[row][col]:
    continue
```

**Impact:**

- Reduced search space
    
- Faster pruning
    
- Worst-case still exponential
    

---

If you want this **converted into handwritten-style images or A4 PDF**, say the word and I’ll do it.