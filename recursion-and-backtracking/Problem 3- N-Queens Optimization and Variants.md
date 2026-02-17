

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
