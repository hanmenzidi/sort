package com.sort.study.lihan.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BiSearchTreeNode {
    private BiSearchTreeNode lchld;
    private BiSearchTreeNode rchld;
    private int data;


}
