@import java.util.List
@param List<String> tasks

<table class="min-w-full divide-y divide-gray-700">
    <thead>
    <tr>
        <th scope="col" class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-white sm:pl-0">Task Description</th>
        <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-white">Status</th>
        <th scope="col" class="relative py-3.5 pl-3 pr-4 sm:pr-0">
            <span class="sr-only">Actions</span>
        </th>
    </tr>
    </thead>
    <tbody class="divide-y divide-gray-800">
    @for(int i = 0; i < tasks.size(); i++)
        <tr>
            <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-white sm:pl-0">${tasks.get(i)}</td>
            <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-300">Pending</td>
            <td class="relative whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-0">
                <button hx-delete="/delete-task/${i}"
                        hx-target="#taskTable"
                        hx-swap="innerHTML"
                        class="text-indigo-400 hover:text-indigo-300">
                    Delete<span class="sr-only">, Task ${i + 1}</span>
                </button>
            </td>
        </tr>
    @endfor
    </tbody>
</table>