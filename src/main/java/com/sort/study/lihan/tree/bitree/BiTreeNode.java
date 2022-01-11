package com.sort.study.lihan.tree.bitree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiTreeNode {
   public BiTreeNode lchld;
    public BiTreeNode rchld;
    public char data;
    public  int val;


}
