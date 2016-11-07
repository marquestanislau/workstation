
<div class="mdl-cell mdl-cell--10-col">
	<table class="table table-striped">
		<thead>
			<tr>
				<th class="mdl-data-table__cell--non-numeric"><?php echo $this->Paginator->sort('id'); ?></th>
				<th><?php echo $this->Paginator->sort('nome'); ?></th>
				<th><?php echo $this->Paginator->sort('apelido'); ?></th>
				<th><?php echo $this->Paginator->sort('data'); ?></th>
				<th><?php echo __('Actions'); ?></th>
			</tr>
		</thead>
		<tbody>
			<?php foreach ($pessoas as $pessoa): ?>
				<tr>
					<td class="mdl-data-table__cell--non-numeric"><?php echo h($pessoa['Pessoa']['id']); ?>&nbsp;</td>
					<td><?php echo h($pessoa['Pessoa']['nome']); ?>&nbsp;</td>
					<td><?php echo h($pessoa['Pessoa']['apelido']); ?>&nbsp;</td>
					<td><?php echo h($pessoa['Pessoa']['data']); ?>&nbsp;</td>
					<td class="actions">
						<?php echo $this->Html->link(__('View'), array('action' => 'view', $pessoa['Pessoa']['id'])); ?>
						<?php echo $this->Html->link(__('Edit'), array('action' => 'edit', $pessoa['Pessoa']['id'])); ?>
						<?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $pessoa['Pessoa']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $pessoa['Pessoa']['id']))); ?>
					</td>
				</tr>
			<?php endforeach; ?>
		</tbody>
	</table>
	<p>
	<?php
	echo $this->Paginator->counter(array(
		'format' => __('Page {:page} of {:pages}, showing {:current} records out of {:count} total, starting on record {:start}, ending on {:end}')
		));
		?>	</p>
		<div class="paging">
			<?php
			echo $this->Paginator->prev('< ' . __('previous'), array(), null, array('class' => 'prev disabled'));
			echo $this->Paginator->numbers(array('separator' => ''));
			echo $this->Paginator->next(__('next') . ' >', array(), null, array('class' => 'next disabled'));
			?>
		</div>

		<?php echo $this->Html->link(__('Novo'), array('action' => 'add', 'class' => 'mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored')); ?>
</div>
<div class="mdl-cell mdl-cell--2-col">
	Actions
	<hr>
	<button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
		<i class="material-icons">add</i>
	</button>
</div>		


