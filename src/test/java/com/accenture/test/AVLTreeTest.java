package com.accenture.test;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class AVLTreeTest
{
    @Test
    public void shouldReturnALeaflessRootNodeWhenInsertingANullNode()
    {
        //given
        int value = 10;
        AVLTree avlTree = new AVLTree();
        Node expected = new Node(value);

        //when
        Node actual = avlTree.insert(null, value);

        //then
        assertThat(actual.getValue(), is(expected.getValue()));
        assertThat(actual.getHeight(), is(expected.getHeight()));
        assertThat(actual.getLeft(), nullValue());
        assertThat(actual.getRight(), nullValue());
    }

    @Test
    public void shouldReturnARootNodeWhenInsertAValueEqualToTheRootNode()
    {
        //given
        int value = 15;
        AVLTree avlTree = new AVLTree();
        Node root = avlTree.insert(null, 15);

        //when
        Node actual = avlTree.insert(root, value);

        //then
        assertThat(actual.getValue(), is(value));
    }

    @Test
    public void shouldReturnARootNodeWithALeafToTheLeftWhenTheRootNodeHasNoLeavesAndTheValueToInsertIsLessThanTheRootValue()
    {
        //given
        int value = 9;
        AVLTree avlTree = new AVLTree();
        Node root = avlTree.insert(null, 15);

        //when
        Node actual = avlTree.insert(root, value);

        //then
        assertThat(actual.getLeft().getValue(), is(value));
    }

    @Test
    public void shouldReturnARootNodeWithALeafToTheRigthWhenTheRootNodeHasNoLeavesAndTheValueToInsertIsBiggerThanTheRootValue()
    {
        //given
        int value = 27;
        AVLTree avlTree = new AVLTree();
        Node root = avlTree.insert(null, 15);

        //when
        Node actual = avlTree.insert(root, value);

        //then
        assertThat(actual.getRight().getValue(), is(value));
    }

    @Test
    public void shouldReturnABalancedRootNodeWhenInsertAValueToTheTreeAndDoASimpleRightRotation()
    {
        //given
        int value = 8;
        AVLTree avlTree = new AVLTree();
        Node root = avlTree.insert(null, 15);
        root = avlTree.insert(root, 27);
        root = avlTree.insert(root, 49);
        root = avlTree.insert(root, 10);

        //when
        Node actual = avlTree.insert(root, value);

        //then
        assertThat(actual.getValue(), is(27));
    }

    @Test
    public void shouldReturnABalancedRootNodeWhenInsertAValueToTheTreeAndDoASimpleLeftRotation()
    {
        //given
        int value = 49;
        AVLTree avlTree = new AVLTree();
        Node root = avlTree.insert(null, 15);
        root = avlTree.insert(root, 27);

        //when
        Node actual = avlTree.insert(root, value);

        //then
        assertThat(actual.getValue(), is(27));
    }

    @Test
    public void shouldReturnABalancedRootNodeWhenInsertAValueToTheTreeAndDoADoubleRotationLeft()
    {
        //given
        int value = 59;
        AVLTree avlTree = new AVLTree();
        Node root = avlTree.insert(null, 15);
        root = avlTree.insert(root, 27);
        root = avlTree.insert(root, 49);
        root = avlTree.insert(root, 10);
        root = avlTree.insert(root, 8);
        root = avlTree.insert(root, 67);

        //when
        Node actual = avlTree.insert(root, value);

        //then
        assertThat(actual.getValue(), is(27));
    }

    @Test
    public void shouldReturnABalancedRootNodeWhenInsertAValueToTheTreeAndDoADoubleRotationRight()
    {
        //given
        int value = 14;
        AVLTree avlTree = new AVLTree();
        Node root = avlTree.insert(null, 15);
        root = avlTree.insert(root, 27);
        root = avlTree.insert(root, 49);
        root = avlTree.insert(root, 10);
        root = avlTree.insert(root, 8);
        root = avlTree.insert(root, 67);
        root = avlTree.insert(root, 9);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, 20);

        //when
        Node actual = avlTree.insert(root, value);

        //then
        assertThat(actual.getValue(), is(15));
    }
}
