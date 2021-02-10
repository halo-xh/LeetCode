/**
 * <p>
 * 回溯法一般步骤
 * </p>
 * * result = []
 * * def backtrack(路径, 选择列表):
 * *   if 满足结束条件:
 * *   result.add(路径)
 * *   return
 * * for 选择 in 选择列表:
 * *   做选择(会有判断要不要选择)
 * *   backtrack(路径, 选择列表)
 * *   撤销选择
 *
 * void backtrack(..,..){
 *     //触发结束条件
 *     if(达到边界){
 *        记录数据，返回
 *     }
 *     for 选择 in 选择列表:
 *     1.排除重叠问题
 *     2.做选择
 *     3.backtrack(..,..)回溯
 *     4.撤销选择
 * }
 *
 */