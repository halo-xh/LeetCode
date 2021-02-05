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
 */