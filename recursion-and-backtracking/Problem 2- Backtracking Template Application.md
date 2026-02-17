
---

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
