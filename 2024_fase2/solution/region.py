n_regions = int(input())

regions = []
for _ in range(n_regions):
  a, b = input().split()
  regions.append([min(a,b), max(a,b)])

served = []
not_served = []

for _ in range(int(input())):
  query = input()
  found = False
  for lower_bound, upper_bound in regions:
    if query >= lower_bound and query <= upper_bound:
      found = True
      break
  if found:
    served.append(query)
  else:
    not_served.append(query)

served.sort()
not_served.sort()

for query in served:
  print(f"{query} is served by our delivery system")
for query in not_served:
  print(f"{query} is not served by our delivery system")
