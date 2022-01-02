package com.sort.study.lihan.tree.bitree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BiTreeNode {
    private BiTreeNode lchld;
    private BiTreeNode rchld;
    private char data;


}
